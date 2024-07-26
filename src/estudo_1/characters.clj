(ns estudo-1.characters
  (:require [estudo-1.predicate :as outro]))

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









