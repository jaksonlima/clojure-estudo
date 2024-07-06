(ns estudo-1.estudo-3)

(defn multa
  [valor]
  (let [percentual 0.1]
    (* valor percentual)))

(defn valor-total
  "calcula multa e retorna com o valor"
  [valor]
  (let [percentual-multa 0.1
        valor-multa (* valor percentual-multa)]
    (+ valor valor-multa))
  )