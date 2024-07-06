(ns estudo-1.estudo-1)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!")
  )

(defn two
  []
  2)

(defn get-double
  [number name]
  (let [value (* 2 number)]
    (str "Olá " name ", o dobro de " number " é " value)
    )
  )


(defn maped
  [vec fn]
  (map fn vec)
  )

(defn minha-lista [] '(1 2 3 4 5 6 7))

(def vetor [1 2 3 4 6 7 8 9])

(def maped {"A" 1 "B" 2})

;(get vetor 0)
;(first vetor)
;(last vetor)
;(count vetor)
;(filter (fn [number] (= (mod number 2) 0)) vetor)
;(filter #(= (mod % 2) 0) vetor)
;(map #(* 2 %) vetor)
;(reduce (fn [number result] (+ result number)) 0 vetor)

;(get maped "A")
;(first vetor)
;(last vetor)
;(count vetor)
;(assoc maped "C" 8)