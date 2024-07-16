(ns estudo-1.mapa-2
  (:require [clojure.string :refer [upper-case join]]))

(defn todas-disciplinas
  []
  [{:nome "Estrutura de dados" :semestre 2}
   {:nome "Algoritmos" :semestre 1}
   {:nome "Inteligência Artificial" :semestre 3}])

(todas-disciplinas)

(defn nome-disiplinas-restantes
  [disciplinas semestre-atual]
  (filter #(>= (:semestre %1) semestre-atual) (disciplinas)))

(defn nome-disiplinas-restantes
  [disciplinas semestre-atual]
  (filter (fn [map] (>= (:semestre map) semestre-atual)) (disciplinas)))

(defn nome-disiplinas-restantes
  [disciplinas semestre-atual]
  (let [filtrado (filter #(>= (:semestre %1) semestre-atual) (disciplinas))]
    (map :nome filtrado))
  )

(defn nome-disiplinas-restantes
  [disciplinas semestre-atual]
  (let [disiplinas (disciplinas)
        filtrado (filter #(>= (:semestre %1) semestre-atual) disiplinas)
        names (map :nome filtrado)
        upper-names (map upper-case names)
        join-names (join ", " upper-names)]
    join-names))

(defn nome-disiplinas-restantes
  [disciplinas semestre-atual]
  (->> (disciplinas)
       (filter #(>= (:semestre %1) semestre-atual))
       (map :nome)
       (map upper-case)
       (join ", ")))

(nome-disiplinas-restantes todas-disciplinas 0)


(def person {:id 1 :name "lima"})

(assoc person :age 27)

(update person :id inc)

(-> person
    (assoc :age 27)
    (update :age inc))

;(def result (future (Thread/sleep 9000) (+ 1 1)))
;@result  ;; Bloca até que o resultado esteja disponível.
;
;(println @result)

(def a (atom 0))
(swap! a inc)
(println @a)








