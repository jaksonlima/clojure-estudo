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


(defn total-ages
  [ages]
  (reduce (fn [sum item] (+ sum (:age item))) 0 ages)
  )

(total-ages [ {:age 15} {:age 15}])

(defn tamanho-medio-dos-nomes
  [nomes]
  (/ (reduce + 0 (map count nomes)) (count nomes)))

(tamanho-medio-dos-nomes ["jakson" "lima"])

(defn menor-que-3
  [nomes]
  (let [nomes-maior-3 (filter #(> (count %1) 3) nomes)]
    nomes-maior-3))

(defn tamanho-medio-dos-nomes-maior-3
  [nomes]
  (let [menor-3 (menor-que-3 nomes)]
    (/ (reduce + 0 (map count menor-3)) (count menor-3)))
  )

(defn tamanho-dos-nomes
  [nomes]
  (map #(count (:name %1)) nomes))

(tamanho-medio-dos-nomes [{:name "jakson"} {:name "lima"} {:name "cod"}])














