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


(s/def :event/type keyword?)
(s/def :event/timestamp int?)
(s/def :search/url #(re-matches #"^https://.*" %1))
(s/def :error/message string?)
(s/def :error/code int?)

(s/conform :search/url "https://lima.com")
(s/valid? :search/url "https://lima.com")

(defmulti event-type :event/type)
(defmethod event-type :event/search [_]
  (s/keys :req [:event/type :event/timestamp :search/url]))
(defmethod event-type :event/error [_]
  (s/keys :req [:event/type :event/timestamp :error/message :error/code]))


(s/def :event/event (s/multi-spec event-type :event/type))

(s/valid? :event/event
          {:event/type :event/search
           :event/timestamp 1463970123000
           :search/url "https://clojure.org"})
(s/valid? :event/event
          {:event/type :event/error
           :event/timestamp 1463970123000
           :error/message "Invalid host"
           :error/code 500})


(s/conform (s/coll-of keyword?) [:a :b :c])
(s/conform (s/coll-of number?) #{5 10 2})


(defn adder [x] #(+ x %2))
((adder 10) 10 5)

(s/fdef clojure.core/declare
        :args (s/cat :names (s/* simple-symbol?))
        :ret any?)


(def suit? #{:club :diamond :heart :spade})
(def rank? (into #{:jack :queen :king :ace} (range 2 11)))
(def deck (for [suit suit? rank rank?] [rank suit]))

(s/def :game/card (s/tuple rank? suit?))
(s/def :game/hand (s/* :game/card))

(s/def :game/name string?)
(s/def :game/score int?)
(s/def :game/player (s/keys :req [:game/name :game/score :game/hand]))

(s/def :game/players (s/* :game/player))
(s/def :game/deck (s/* :game/card))
(s/def :game/game (s/keys :req [:game/players :game/deck]))

(def kenny
  {:game/name "Kenny Rogers"
   :game/score 100
   :game/hand []})
(s/valid? :game/player kenny)

(s/explain :game/game
           {:game/deck deck
            :game/players [{:game/name "Kenny Rogers"
                            :game/score 100
                            :game/hand [[2 :banana]]}]})

(def status {:status 0})