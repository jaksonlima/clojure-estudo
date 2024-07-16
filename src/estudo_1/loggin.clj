(ns estudo-1.loggin
  (:require [clojure.tools.logging :as log]))

(defn exemplo-funcao []
  (log/info "Este é um log de informação.")
  (log/debug "Este é um log de debug.")
  (log/warn "Este é um log de aviso.")
  (log/error "Este é um log de erro."))

(exemplo-funcao)

(defn execute
  [fn-logger]
  (fn-logger)
  (println "executed your operation..."))

(defn implementation-logger
  [message]
  (log/info message))

(defn logger
  [message]
  (fn [] (log/info message)))

(execute (logger "Test de clean architecture"))

(defn cond-v0
  [value]
  (cond
    (= value 1)  (println "1")
    (= value 2)  (println "2")
    (= value 3)  (println "3")
  ))

(cond-v0 2)