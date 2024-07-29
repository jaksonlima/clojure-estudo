(ns estudo-1.characters
  (:require [estudo-1.predicate :as outro]
            [clojure.core.async :refer [chan]])
  (:import (basex.core BaseXClient$EventNotifier))
  (:import (java.util Date))
  )

(str (Date.))

'(1 "two" 3.0)
(get ["a" 13.7 :foo] 1)
(keys {:a 1 :b 2})
#{1 2 3 4 2}
(hash-set 1 2 3 4 2)
[1 2 3 #_ 4 5]
{:a 1, #_#_ :b 2, :c 3}
(re-matches #"^test$" "test")
(fn [line] (println line))
#(println %)
(macroexpand `#(println %))
(read-string "#'foo")
(def nine 9)
(var nine)
(/ 1.0 0.0)
(Math/sqrt -1.0)
(def edn-data "{:nome \"Alice\" :idade 30}")
(def parsed-data (edn/read-string edn-data))
(type #inst "2014-05-19T19:12:37.925-00:00")
(read-string "#inst \"2014-05-19T19:12:37.925-00:00\"")
(#(println % %1 %&) 0 1 2 3 4)
(def x (atom 1))
(def ^{:debug true :started 0} five 5)
(:file (meta #'five))

(def ^int five 5)
(meta #'five)

(quote (1 2 3))

(def my-map {:one 1 :two 2 :three [{:id 1}]})

(:id (get (:three my-map) 0))

(keyword "test")
(def my-map {:one 1 :two 2})
(:one my-map)
(get my-map :three 3)
(:three my-map 0)
(get  my-map :three)

::my-keyword
:user/my-keyword
(= ::my-keyword :my-keyword)

(def dados {::status ::outro/status})
(println dados)

(defn printed [data]
  (println data))

(printed dados)


#:person{:first "Han"
         :last "Solo"
         :ship #:ship{:name "Millennium Falcon"
                      :model "YT-1300f light freighter"}}

(keys {:user/a 1, :user/b 2})
(keys #::{:a 1, :b 2})

#:shape{:_/type "Square"
        :location/x 10
        :location/y 12
        :sides 4
        :width 2
        :height 2}

(str \h \i)
(def five 5)

(defmacro debug [body]
   `(let [val# ~body]
      (println "DEBUG: " val#)
      (println "DEBUG: " ~body)
      val#))

(debug (+ 2 2))

`[inc ~(+ 1 five)]

`five

(defn- build-notification
  [notifier-action]
  (reify BaseXClient$EventNotifier
    (notify [this value]
      (notifier-action value))))

(def three-and-four '(3 4))

`(1 ~three-and-four)
`(1 ~@three-and-four)

(defmacro m [] `(let [x# 1] x#))

(m)
(macroexpand '(m))

(defn- conded
  [value]
  (cond
    (= 1 value) (println "ok one")
    (= 2 value) (println "ok two")
    )
  value
  )

(conded 2)

(not (= 1 0))

(def my-channel (chan 10))

(>!! my-channel "hello")
(println (<!! my-channel))

(def c (chan))

(>! c "nope")


;(def my-buffer (buffers/create-buffer [1 2 3]))
;(buffers/empty my-buffer)


(def my-stateful-thing (atom 0))

(swap! my-stateful-thing inc)

(println @my-stateful-thing)

(defn- private
  []
  (fn [arg1 _] (< 0 arg1)))

((private) 1 0)

(def value (atom 0))

(add-watch value nil (fn [_ _ _ new-value]
                       (println new-value)))

(reset! value 6)
(reset! value 9)


(def m {:a 1, :b 2, :c 3})

(def my-line [[5 10] [10 20]])

(let [p1 (first my-line)
      p2 (second my-line)
      x1 (first p1)
      y1 (second p1)
      x2 (first p2)
      y2 (second p2)]
  (println "Line from (" x1 "," y1 ") to (" x2 ", " y2 ")"))

(def meu-atom (atom 0))
(println @meu-atom)
(swap! meu-atom + 3)
(reset! meu-atom 10)

(def estado (atom {:contador 0, :mesagens []}))

(swap! estado update :mesagens conj "2")
(swap! estado update :contador inc)
(swap! estado assoc :contador 55)
(swap! estado assoc :mesagens ["test1" "test3"])
(reset! estado {:contador 10, :mesagens ["1"]})

(println @estado)

(def my-line [[5 10] [10 20]])
(let [[[x1 y1] [x2 y2]] my-line]
  (println "Line from (" x1 "," y1 ") to (" x2 ", " y2 ")"))

(def small-list '(1 2 3))
(let [[a b c d e f g] small-list]
  (println a b c d e f g))

(def large-list '(1 2 3 4 5 6 7 8 9 10))
(let [[a b c] large-list]
  (println a b c))


(def names ["Michael" "Amber" "Aaron" "Nick" "Earl" "Joe"])

(let [[one two & all] names]
  (println one ", " two ", rest ->" all)
  names)

(let [[item :as all] names]
  (println item all)
  names)

(def numbers [1 2 3 4 5])
(let [[x & remaining :as all] numbers]
  (apply prn [remaining all]))

(def word "Clojure")
(let [[x & remaining :as all] word]
  (apply prn [x remaining all]))


(def fruits ["apple" "orange" "strawberry" "peach" "pear" "lemon"])
(let [[item1 _ item3 & remaining :as all-fruits] fruits]
  (println "The first and third fruits are" item1 "and" item3)
  (println "These were taken from" all-fruits)
  (println "The fruits after them are" remaining))


(def my-line [[5 10] [10 20]])
(let [[[x1 y1][x2 y2]] my-line]
  (println "Line from (" x1 "," y1 ") to (" x2 ", " y2 ")"))


(let [[[a b :as group1] [c d :as group2]] my-line]
  (println a b group1)
  (println c d group2))

(def client {:name "Super Co."
             :location "Philadelphia"
             :description "The worldwide leader in plastic tableware."})

(let [name (:name client)
      location (:location client)
      description (:description client)]
  (println name location "-" description))

(let [{name :name
       location :location
       description :description} client]
  (println name location "-" description))

(let [{name :name
       location :location
       description :description} client]
        (println name location "-" description)
                                  (println "okokok"))

(defn test [a b c d]
  (println a b c d))

(test "" "" "" (fn [value] value))

(do
  (println "step 1")
  (println "step 1")
  (println "step 1")
  false
  true
  )

(try
  (println "next step")
  (throw (RuntimeException. "This is a runtime exception"))
  (catch Exception e
    (throw (RuntimeException. "Error is expected"))))


(defn anded
  [])
(and
  (< 3 2)
  (< 3 2)
  (< 3 2)
  )

(def person {:id 4 :name "lima" :hair-color "green" :profiles [{:type 1}]})
(assoc person :id 2)
(update person :id inc)
(update person :id #(+ %1 %1))
(update person :id (fn [value] (* value value)))
(update person :id (fn [_] 1))

(defn transform [person]
  (update (assoc person :hair-color :gray) :age inc))

(transform {:name "Socrates", :age 39})

(defn transform* [person]
  (-> person
      (assoc :hair-color :gray)
      (update :age inc)))


(defn transform* [person]
  (-> person
      (assoc ,,, :hair-color :gray)
      (update ,,, :age inc)))

(transform {:name "Socrates", :age 39})
(transform* {:name "Socrates", :age 39})

(-> person :hair-color name clojure.string/upper-case)
(clojure.string/upper-case (:hair-color person))

(defn calculate []
  (reduce + (map #(* % %) (filter odd? (range 10)))))

(calculate)

(defn calculate* []
  (->> (range 10)
       (filter odd? ,,,)
       (map #(* % %) ,,,)
       (reduce + ,,,)))

(as-> [:foo :bar] v
      (println v)
      (map name v)
      (first v)
      (.substring v 1))

(map :id [{:id 1} {:id 2}])

(as-> [:foo :bar] v
      (map name v)
      (first v)
      (.substring v 1)
      (clojure.string/upper-case v))

(some-> (compute) Long/parseLong)

(defn describe-number [n]
  (cond-> ["start"]
          (odd? n) (conj "odd")
          (even? n) (conj "even")
          (zero? n) (conj "zero")
          (pos? n) (conj "positive")))

(describe-number 3)
(describe-number 4)









