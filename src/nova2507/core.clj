;(ns cows.core
;  (:gen-class))

;(defn -main
;  "I don't do a whole lot ... yet."
;  [& args]
;  (println "Hello, World!"))
(println)
(println)
(println)
(println)
(println)
(println)
(println)
(println)
(println)
(println)
(println)



(println "welcome to demo!") 



(def character
  {:default
    {:CONS 5
    :FUER 5
    :ESEN 5
    :INTE 5
    :SABI 5
    :SUER 5
    :DEST 5
    :AGIL 5
    :VOLU 5
    :BELL 5
    :CARI 5
    :PODE 5
    }})


(defn val-atr
  "permite consultar los atributos de un pj. Si no se mete ningun nombre de pj, devuelve susodicho atributo de un pj ejemplo."
  ([] character)
  ([atr]
    (atr (:default character)))
  ([pj atr]
    (atr (pj character))))


;(println (val-atr)
;(println (val-atr :CONS)
;(println (val-atr :default :CONS)
;debería salir en el primero todos los atributos y en los otros dos, un 5 como respuesta salvo modificación.

(def valor_caract
  {:hp [:CONS :FUER :ESEN :VOLU * 25]
  :hp_reg [:CONS :ESEN :SABI :PODE * 4]
  :mana [:CONS :ESEN :VOLU :PODE * 20]
  :mana_reg [:ESEN :SABI :INTE :PODE * 1]
  :energia [:CONS :ESEN :VOLU :AGIL * 5]
  :energia_reg [:CONS :SABI :AGIL :PODE * 1]
  :atq_fisico [:FUER :SUER :DEST :AGIL * 1]
  :damage [:CONS :FUER :DEST :PODE * 1]
  :critico [:FUER :SUER :AGIL :PODE * 1]
  :peso_max [:CONS :FUER :VOLU :PODE * 3]
  :acum_vel [:AGIL :DEST :INTE :PODE * 3]
  :acum_max [:ESEN :INTE :CONS :VOLU * 10]
  :boon_time [:ESEN :SABI :VOLU :CARI * 150] ;milésimas de segundo. Digamos lo normal serían 3 segundos.
  :condi_time [:ESEN :INTE :VOLU :CARI * 150]
  })


;(println (keys valor_caract))
;(println (count (keys valor_caract)))

(defn crea
  "crea el character nombrado o en su defecto a default"
  ([]
    (crea :default))
  ([character]
    (let [gensym {}]
      (conj gensym ["cupe dentro" "dfasd"]))))

;(println (crea))





;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;COMBAT SECCTION!!!;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;

(def jugadores ["arquero" "mago" "guerrero" "healer" "paladin"])
(def jugador [1 2 3 4])







(defn batalla 
  "select two enemys to fight"
  []
  (let [gensym (rand-nth jugadores)]
    (let [p1 gensym]
      (let [gensym (rand-nth jugadores)]
        (let [p2 gensym]
          (let [jugadores [p1 p2]]
            (def contendientes jugadores)
            jugadores))))))
(batalla)

(println "contendientes:")
(println (first contendientes) "and " (second contendientes))

(println "the winner is: " (rand-nth contendientes) "!!!")







;rand-nth





(loop [gensym 0]
  (println gensym)
  (if (> gensym 2)
    (println "All is done, any exception would mean that this have just been finished.")
    (recur (inc gensym))))



(println)
(println)
(println)
(println)
(println)
(println)
(println)
(println)
(println)
(println)
