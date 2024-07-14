(ns estudo-1.mapa)

{:name "Jakson" :sobrenome "lima" :idade 27}

;Carinho de compras

(defn compras
  []
  {:tomate { :quantidade 2 :preco 5 :values [{:type 0}]}
   :arroz { :quantidade 2 :preco 5} })

(compras)

(get (compras) :tomate)
(:tomate (compras))
((compras) :tomate)

(:preco (:tomate (compras)))
(:quantidade (:tomate (compras)))

(:batata (compras) {:quantidade 0 :preco 0})

(def my-map
  {:item 1 :nome "tomate" :preco 10})

(conj (compras) {:alface {:quantidade 1 :preco 20}})

(assoc my-map :my { :quantidade 6 })

(dissoc my-map :preco)

(update {:name "lima" :age 17} :age inc)

(inc 39)

(update-in (compras) [:tomate :preco] * 2)
























