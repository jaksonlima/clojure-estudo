(ns estudo-1.mapa-2)

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

(nome-disiplinas-restantes todas-disciplinas 0)