(ns estudo-1.filter-map-reduce)

(defn esta-quinto-ano?
  [v]
  (println v)
  (= 5 v))

(defn quantidade-estudante-quinto-ano
  [estudantes]
  (count (filter esta-quinto-ano? estudantes)))

(defn quantidade-estudante-quinto-ano
  [estudantes]
  (count (filter (fn [v] (= v 5)) estudantes)))

(defn quantidade-estudante-quinto-ano
  [estudantes]
  (count (filter #(= 5 %1) estudantes)))

(defn total-idade
  [idades]
  (reduce #(+ %1 %2) idades))

(defn total-idade
  [idades]
  (reduce (fn [current actual] (+ current actual)) idades))

(defn total-idade
  [idades]
  (reduce + idades))

(defn total-idade-2
  [idades]
  (reduce (fn [current total] (println total current) (+ (:age current) (:age total))) idades))