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

(defn upper
  [value]
  (clojure.string/upper-case value))

(defn nome-disiplinas-restantes
  [disciplinas semestre-atual]
  (let [filtrado (filter #(>= (:semestre %1) semestre-atual) (disciplinas))
        names (map :nome filtrado)]
    (map upper names))
  )

(nome-disiplinas-restantes todas-disciplinas 0)
