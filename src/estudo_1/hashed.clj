(ns estudo-1.hashed)

(def players #{"Alice", "Bob", "Kelly", "Ivete"})

(conj players "Jakson" "Lima")

(disj players "Bob" "Lima")

(contains? players "Bob")

(sorted-set "Alice", "Bob", "Kelly", "Ivete")

;(sorted-set-by "Alice", "Bob", "Kelly", "Ivete")

(def players #{"jakson"})
(def new-players #{"lima"})
(into players new-players)

(def scores {"jakson" 12345, "lima" 67890 :key "value"})

(assoc scores "Wilson" 9876)

(dissoc scores "lima")

(get scores "lima")

(:key scores)

(scores :maped 0)

(contains? scores :key)

(find scores "lima")

(keys scores)
(vals scores)

(def players #{"Alice" "Bob" "Kelly"})
(zipmap players (repeat 10))


(def scores {:key 1})
(def new-scores {:key 1})
(merge scores new-scores)
(merge-with + scores new-scores)

(def sm (sorted-map
          "Bravo" 204
          "Alfa" 35
          "Dir" 99
          "Charlie" 100))

(def person
  {:first-name "Kelly"
   :last-name "Keen"
   :age 32
   :occupation "Programmer"})

(get person :occupation)
(person :occupation)
(:occupation person)
(:favorite-color person "beige")

(assoc person :occupation "Baker")
(dissoc person :age)

(def company
  {:name "WidgetCo"
   :address {:street "123 Main St"
             :city "Springfield"
             :state "IL"}})

(company :address)
(->> company :address :state)
(->> company :address :city)
(get-in company [:address :city])
(assoc-in company [:address :street] "303 Broadway")
;(update-in company [:address :street] "303 Broadway")

(defrecord Person [first-name last-name age occupation])
(def lima (->Person "jakson"  "lima" 28 "Programmer"))
(def lima (map->Person
            {:first-name "Jakson"
             :age 28
             :last-name "Lima"
             :occupation "Programmer"}))

(:occupation lima)

(def my-map [{:id 1 :person {:name "jakson"}}
             {:id 2 :person {:name "wilson"}}
             {:id 3 :person {:name "lima"}}])

(def extract-my-map
  (->> my-map
       (map :person)
       (map :name)))

(def extract-my-map
  (->> my-map
       (map (fn [value] (:person value)))
       )
  )

(def extract-my-map
  (->> my-map
       (map (fn [value] (->> value :person :name)))
       )
  )


(def extract-my-map
  (->> my-map
       (map #(->> %1 :person :name))
       )
  )

































