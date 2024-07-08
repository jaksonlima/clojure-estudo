(ns estudo-1.core)

(defn taxa-entrega
  [value]
  (let [valor-de-15 15 valor-de-5 5 valor-de-0 0]
    (if (<= value 100)
      valor-de-15
      (if (<= value 200)
        valor-de-5
        valor-de-0
        )
      )
    )
  )
