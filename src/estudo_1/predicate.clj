(ns estudo-1.predicate
  (:require [clojure.spec.alpha :as s])
  (:import [java.util Date]))

(even? 9)
(s/conform even? 9)
(s/valid? even? 9)
(s/def :order/date inst?)
(s/def :deck/suit #{:club :diamond :heart :spade})
(s/valid? :order/date (Date.))
(s/conform :deck/suit :club)

(s/def :unq/person
  (s/keys :req-un [:acct/first-name :acct/last-name :acct/email]
          :opt-un [:acct/phone]))

(s/explain :unq/person
           {:first-name "Bugs"
            :last-name "Bunny"
            :email "n/a"})

(s/explain :unq/person
           {:first-name "Bugs"})


(defrecord Person [first-name last-name email phone])

(s/explain :unq/person
           (map->Person {:first-name "Bugs"}))


(s/def :my.config/port number?)
(s/def :my.config/host string?)
(s/def :my.config/id keyword?)
(s/def :my.config/server (s/keys* :req [:my.config/id :my.config/host]
                                  :opt [:my.config/port]))
(s/conform :my.config/server [:my.config/id ":s1"
                              :my.config/host "example.com"
                              :my.config/port 5555])

(s/valid? :my.config/server [:my.config/id ":s1"
                              :my.config/host "example.com"
                              :my.config/port 5555])

;-------------------------------------------------------------------

(s/def :order/date inst?)
(s/valid? :order/date "")
(s/conform :order/date "")

(s/def :person/check #{:name :age})
(s/valid? :person/check :name)
(s/conform :person/check :age)

(s/def :name/check string?)

(s/valid? :name/check "lima")
(s/valid? :name/check 0)

(s/def :age/check (s/and int? even? #(>= % 500)))

(s/valid? :age/check 10)
(s/valid? :age/check 500)
(s/valid? :age/check "")

(s/def :domain/name-or-id (s/or :name string? :id int?))

(s/conform :domain/name-or-id "10")
(s/conform :domain/name-or-id 10)

(s/valid? string? nil)
(s/valid? (s/nilable string?) nil)

(s/explain :person/check :name)

(s/explain-data :domain/name-or-id :foo)

(def email-regex #"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,63}$")

(s/def :check/email-regex (s/and string? #(re-matches email-regex %)))

(s/def :check/name string?)
(s/def :check/age int?)
(s/def :check/email :check/email-regex)

(s/valid? :check/email "lima@gmail.com")

(s/def :check/person (s/keys :req [:check/name :check/age]
                                 :opt [:check/email]))

(s/valid? :check/person
          {:check/name "lima"
           :check/age 27
           :check/email "a@b.com"})

(s/conform :check/person
          {:check/name "lima"
           :check/age 27
           :check/email "a@b.com"})

(s/explain :check/person
           {:check/name "Bugs"})

(s/def :check-un/person
  (s/keys :req-un [:check/name :check/age]
          :opt-un [:check/email]))

(s/conform :check-un/person
           {:name "lima"
            :age 27
            :email "a@b.com"})

(defrecord Person [name age email])

(s/explain :check-un/person
           (->Person "lima" 28 ""))

(s/conform :check-un/person
           (->Person "lima" 28 "a@a.com"))

(s/def :my.config/port number?)
(s/def :my.config/host string?)
(s/def :my.config/id keyword?)
(s/def :my.config/server (s/keys* :req [:my.config/id :my.config/host]
                                  :opt [:my.config/port]))
(s/conform :my.config/server [:my.config/id :s1
                              :my.config/host "example.com"
                              :my.config/port 5555])


(s/def :animal/kind string?)
(s/def :animal/says string?)
(s/def :animal/common (s/keys :req [:animal/kind :animal/says]))
(s/def :dog/tail? boolean?)
(s/def :dog/breed string?)
(s/def :animal/dog (s/merge :animal/common
                            (s/keys :req [:dog/tail? :dog/breed])))
(s/valid? :animal/dog
          {:animal/kind "dog"
           :animal/says "woof"
           :dog/tail? true
           :dog/breed "retriever"})










































