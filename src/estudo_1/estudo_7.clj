(ns estudo-1.estudo-7)

;(def person [{:name "lima" :age 27}
;             {:name "jakson" :age 28}])
;
;(defn add-timestamp
;  [person]
;  (let [name (:name person)]
;    (str name " - " "11-07-2024")))
;
;(def names-with-timestamp (map add-timestamp person))
;
;(println names-with-timestamp)


(def person-v1 {:name "lima" :age 27})

(def named (:name person-v1))
(def named-v2 (get person-v1 :name))

(println named named-v2)

(defn high-order
  [my-fn]
  (my-fn))

(def my-value 5)

(def my-fn (fn [] (println "running!!")))

;(high-order my-fn)

(filter (fn [value] (= value 2)) [1 2 3])

(map (fn [v] (* v 2)) [1 2 3 4])

(def people [{:name "Alice" :age 30}
             {:name "Bob" :age 25}
             {:name "Charlie" :age 35 :id 1}])

(def names (map :name people))

;(println names)

(def numbers [1 2 3 4])

(defn inc-
  [value]
  (* value 2))

(map inc- numbers)
