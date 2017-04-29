(println)
(println)
(println)
(println)
(println)
(println)


(defmacro debug
  "coge una funcion entrecomillada y la ejecuta al tiempo que la imprime, digamos es un debuger"
  [arg]
  (println)
  (println "Debug: " (str arg))
  (println "Resultado del debug:")
  (println (time (eval (read-string (str arg)))))
  (println))


(def fdc_
  "First, Drop, Count the next 2 arguments, first is subject of be counted and second is subject to be droped and then, get first"
 #(first (drop (count %1) %2)))


(def atr_catcher
 #(if (% :atributes) (% :atributes) %))


(defn section
  "make sections during run time visualy separated and more comfortable"
  [seci]
  (println)
  (println)
  (let [gensym (count seci)]
    (loop [nu 0]
      (if (< nu (+ 6 gensym))
        (do (print "-")
            (recur (inc nu)))
        (println)))
    (print "--" seci "--")
    (println)
    (loop [nu 0]
      (if (< nu (+ 6 gensym))
        (do (print "-")
            (recur (inc nu)))
        (println)))))


(section "welcome to NOVA 2057!!")


(section "preubas phase, CHARACTER SECTION")

;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;CHARACTER SECTION;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;

;character default and samples:

(def default
  {
  :character_identification {}
  :atributes
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
    }
    :characteristics {}
    :talents {}
    :armor {}
    :inventory {}
    :character_relationships {}
  })
;atributos ocultos y no elegibles (son muy variables y dependen de la relacion con su entorno): fe (faith),


(def char_preuba
  "preuba trampa!!!"
  {:atributes {:SAYAN 99 :PALANCA 594 :INTE 9 :PODE 4 :BELL 3 :CARI 9 :SUER 10 :CHARMANDER 555 
  :FUER 4 :VOLU 7 :CONS 3 :viso 12903 :AGIL 5 :SABI 7 :ESEN 5 :DEST 8 :SUPER_SAYAN 9000}})


;(def full_character_sample_empty
;  "Instead full_character_sample_empty, would be his unique ID or something else which help program to look for."
;  {
;  :character_identification {}
;  :atributes {}
;  :characteristics {}
;  :talents {}
;  :armor {}
;  :inventory {}
;  :character_relationships {}
;  })


(def valor_caract
  {:hp [:CONS :FUER :ESEN :VOLU * 25]
  :hp_reg [:CONS :ESEN :SABI :PODE * 4]
  :dam_red [:CONS :ESEN :FUER :PODE * 1]
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
;to add: pay reduction, sell increased, charming (encantar), science, 



;;;counting valor_caract, atributes per caract and per every caract, are all them with the same number of atributes? all here:

(defn alineator_test
  "count the nº of atributes or components in the kind, characteristics or whatever thing, which are guaranteed that all of them have the same nº. v: 2"
  [body_test]
  (let [nº_types (count (keys body_test))]
    (loop [component_per_type []]
      (if (= (count component_per_type) nº_types)
        (do (reduce #(if (= %1 %2) %1 (do (println "***ERROR MESSAGE: COUNTING COMPONENT PER TYPE***")
                                                   "***ERROR MESSAGE: TYPES ARE NOT REGULAR***")) component_per_type))
        (recur (conj component_per_type (count (body_test (first (fdc_ component_per_type body_test))))))))))


(def c_a_p_c_future
  "futuriza count_atrb_per_caract para simplificar computación dando el resultado desde la caché"
  (future (alineator_test valor_caract)))


(defn count_caract
  "En resumen, se ejecuta o se recoge de cache la cuenta de atributos y atributos por característica realizado en count_atrb_per_caract"
  []
 @c_a_p_c_future)


;;;end counting valor_caract...


(defn gen_atrb
  "genera aleatoriamente tantos atributos (en número) como posea :default con valores comprendidos entre 3 y 10"
  []
  (let [n_atrb (count (default :atributes))]
      (loop [contain []]
        (if (= (count contain) n_atrb)
            (if (= (* 6 n_atrb) (reduce + contain))
                contain
                    (gen_atrb))
            (recur (conj contain (+ 2 (rand-int 9))))))))


(def A_G_C
  "Auto_Gen_Character"
   true)


(defn creator
  "gen a character atributes randomly if auto_gen_character (A_G_C) is enabled (true)."
  []
  (if A_G_C
    (let [charac (zipmap (keys (:atributes default)) (gen_atrb))] charac)
    (println "ERROR: CREATOR NOT PREPARED TO GENERATE CHARACTER MANUALLY!!")))


(def char_preuba
  "preuba trampa!!!"
  {:SAYAN 99 :PALANCA 594 :INTE 9 :PODE 4 :BELL 3 :CARI 9 :SUER 10 :CHARMANDER 555 
  :FUER 4 :VOLU 7 :CONS 3 :viso 12903 :AGIL 5 :SABI 7 :ESEN 5 :DEST 8 :SUPER_SAYAN 9000})



;función inteligente para sustituir (first (drop (count "contador") "vector")) basicamente.
;aun así, propongo hacer una lazy sec, para invocarla con "take x" y que devuelva una secuencia entera que reduce o algo pueda usar.
;en plan (pero que funcione) (quizás un loop soltando algo en cada recur (para que el nº de arg del siguiente no interfiera...):

;(defn recursive_fdc 
;  ([]
;    #(first %)
;    (recursive_fdc 1)) 
;  ([contador] 
;  #(first (drop contador) %) 
;  (recursive_fdc (inc contador))))



(defn calc_caract
  "calcula el valor de la caract_Solicitada pedida para el pj argumento o sus atributos de manera mas eficaz. v: 2"
  [caract_s atrb]
  (loop [gensym []]
    (if (= (count gensym) (- (count_caract) 2))
      (let [
        f (first (drop (count gensym) (caract_s valor_caract)))
        xval (last (caract_s valor_caract))]
          (f xval (reduce + gensym)))
      (recur (conj gensym ((atr_catcher atrb) (first (drop (count gensym) (caract_s valor_caract)))))))))

;ejemplo calc_caract: (debug (calc_caract :hp char_preuba)  ;->nos dará: el valor del hp del pj char_preuba.


(defn conversor_atrb
  "transform input atributes (or character) to output characteristics of him. k are keys and v is the vector value of all those characteristics. v: 1"
  [character]
  (let [k_caract (keys valor_caract)]
      (loop [v_caract []]
          (if (= (count v_caract) (count k_caract))
              (zipmap k_caract v_caract)
              (recur (conj v_caract (calc_caract (fdc_ v_caract k_caract) (atr_catcher character))))))))

(def traits_atributes
  "what atribute are directly relationated with which trait kind"
  {:metha [:ESEN :INTE :VOLU :PODE]
  :phisics [:CONS :FUER :DEST :AGIL]
  :nexo [:SABI :SUER :BELL :CARI]})

(def c_t_f
  "test traits_atributes to know their number of objects and cache result"
  (future (alineator_test traits_atributes)))

(defn count_traits
  "with all, take futuriced traits counting test"
  []
  @c_t_f)


(defn atr_traits
  "give how much points of that kind for that pj"
  [pj kind]
  (loop [gensym []]
    (if (= (count gensym) (count_traits))
      (reduce + gensym)
      (recur (conj gensym ((atr_catcher pj) (fdc_ gensym (traits_atributes kind))))))))


(defn traits_points
  "gives how much trait points should have the pj for each kind"
  [pj]
  (let [metha_points (atr_traits pj :metha)
        phisics_points (atr_traits pj :phisics)
        nexo_points (atr_traits pj :nexo)]
    (zipmap [:metha :phisics :nexo] [metha_points phisics_points nexo_points])))


(defn gen_character
  "gen a random and fully new character from scratch. v: 1" ;may gen character with names or class name in the future.
  []
  (let [gensym (assoc {} :atributes (creator))]
    (assoc gensym :characteristics (conversor_atrb (atr_catcher gensym))
                  :traits_points (traits_points (atr_catcher gensym)))))





(section "preubas phase, COMBAT SECTION")

;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;COMBAT SECCTION!!!;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;


;Lets do rock and roll!!!

(defn class_pj
  "decide which class is the character looking on their atributes and traits"
  [pj]
  (let [traits (:traits_points pj)]
    (or
      (if (< 36 (traits :metha))
        (if (< 42 (:metha traits))
          "archie metha"
          "metha"))
      (if (< 36 (traits :phisics))
        (if (< 42 (:phisics traits))
          "big"
          "skilled"))
      (if (< 36 (traits :nexo))
        (if (< 42 (traits :nexo))
          "grand master"
          "master"))
      (if (< 54 (+ (traits :phisics) (traits :nexo)))
        (if (< (traits :nexo) (traits :phisics))
          "great fighter"
          "great strategist"))
      (if (< 54 (+ (traits :metha) (traits :nexo)))
        (if (< (traits :nexo) (traits :metha))
          "high sorcerer"
          "great philosopher"))
      (if (< 54 (+ (traits :phisics) (traits :metha)))
        (if (< (traits :phisics) (traits :metha))
          "great warlock"
          "great magic fighter"))
      (if (> (traits :metha) (traits :phisics))
        (if (> (traits :metha) (traits :nexo))
          (if (< (traits :nexo) (traits :phisics))
            "warlock"
            "sorcerer")))
      (if (> (traits :phisics) (traits :metha))
        (if (> (traits :phisics) (traits :nexo))
          (if (< (traits :nexo) (traits :metha))
            "magic fighter"
            "fighter")))
      (if (> (traits :nexo) (traits :metha))
        (if (> (traits :nexo) (traits :phisics))
          (if (< (traits :phisics) (traits :metha))
            "philosopher"
            "strategist")))
      (if (= (traits :phisics) (traits :metha))
        "mystic fighter"
        (if (= (traits :metha) (traits :nexo))
          "mystic expert"
          (if (= (traits :phisics) (traits :nexo))
            "expert fighter"
      (if (= (traits :metha) (traits :phisics) (traits :nexo))
        "ex-anime"))))
      "non-charactericed"))
    )


;(println "diez restado:" (- 20 1 2 3 4))
;(println "preuba inc" (map inc [2 3 4 5 6 7]))

;(:t (:combat p1))
;(:acum_max (:characteristics p1))
;(:acum_vel (:characteristics p1))
;(- (:acum_max (:characteristics p1)) (:acum_vel (:characteristics p1)) (:t (:combat p1)))
;(map #(- (:acum_max (:characteristics %)) (:acum_vel (:characteristics %)) (:t (:combat %))) [p1 p2])

(println (sort [2 5 1 3 0 4 6]))
(println "whata happen" (#(let [[%] %] %) (map vals (vals {:lax {:lat 2} :lev {:lat 0} :liv {:lat 1}}))))
(println)
(println "preubas" (vals {:wig {:lax 10} :weg {:lax 2} :wiv {:lax 5} :wev {:lax 0}}))
(println)
(println "compare" (compare 22 12))
(println)
(println "" )
(println)
(println "pre sort-by" (#(let [[gensym] (map keys (vals %))] gensym) {:wig {:lax 10} :weg {:lax 2} :wiv {:lax 5} :wev {:lax 0}}))
;(println "sort-by" (sort-by #(let [[gensym] (map vals (vals %))] gensym) {:wig {:lax 10} :weg {:lax 2} :wiv {:lax 5} :wev {:lax 0}}))



(println (macroexpand '(when true 2 22)))

(def t_to_react
  "calculate the time to react for the following character and throw his time."
  #(- (:acum_max (:characteristics %)) (:acum_vel (:characteristics %)) (:t (:combat %))))


(debug (t_to_react (assoc (gen_character) :combat {:t 0 :hp (:hp (:characteristics (gen_character)))}) ))
;                (assoc (gen_character) :combat {:t 0 :hp (:hp (:characteristics (gen_character)))})))
 


(defn comb_seq
  [p1 p2 temp]
  (println)
  (println "p1 acumax:" (:acum_max (:characteristics p1)) "and acum_vel:" (:acum_vel (:characteristics p1)))
  (println "p2 acumax:" (:acum_max (:characteristics p2)) "and acum_vel:" (:acum_vel (:characteristics p2)))
  (println "time:" temp)
  (println "f to loca:::" (sort (map t_to_react [p1 p2])))
  (let []
  ()))
;  [p1 p2 temp])

(loop []
(println (comb_seq (assoc (gen_character) :combat {:t 0 :hp (:hp (:characteristics (gen_character)))}) 
                  (assoc (gen_character) :combat {:t 0 :hp (:hp (:characteristics (gen_character)))})
                  0))
(recur))


(defn fight!
  "take control of hp and time elaphsed, if anybody die during the battle, this function will control that he stop fighting"
  [p1 p2]
    (loop [p1 (assoc p1 :combat {:t 0 :hp (:hp (:characteristics p1))})
           p2 (assoc p2 :combat {:t 0 :hp (:hp (:characteristics p2))})
          temp 0]
      (println "hp " (class_pj p1)":" (:hp (:combat p1)) "and " (class_pj p2)":" (:hp (:combat p2)))
      (if (> 0 (:hp (:combat p1)))
        (if (> 0 (:hp (:combat p2)))
            (do (println "no-one won...")
              nil)
            (do (println "the winner is:" (class_pj p2))
              p2))
        (if (> 0 (:hp (:combat p2)))
            (do (println "the winner is:" (class_pj p1))
              p1)
            (recur (first(comb_seq p1 p2 temp)) (second (comb_seq p1 p2 temp)) (last (comb_seq p1 p2 temp)))))))


(defn battle
  "Output drop 2 players and which of them was the winner."
  []
    (let [p1 (gen_character)
          p2 (gen_character)]
      (fight! p1 p2)))

;(debug (battle))


;rock_and_roll mode: off...


(def jugadores ["arquero" "mago" "guerrero" "healer" "paladin"])
(def jugador [1 2 3 4])



(defn batalla 
  "select two enemys to fight"
  []
    (let [p1 (gen_character)]
        (let [p2 (gen_character)]
          (let [jugadores [p1 p2]]
            (def contendientes jugadores)))))
;(batalla)

;(println "contendientes:")
;(println (first contendientes) "and " (second contendientes))

;(println "the winner is: " (rand-nth contendientes) "!!!")



(section "preubas phase, HTTP SECTION")

;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;HTTP SECTION;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;

; Hace falta :require para http.kit?
(require '[org.httpkit.client :as http])
(require '[clojure.data.json :as json])


(let [response1 (http/get "http://207.154.200.234:5000/api/blog/categories/")]
    (println "server status: " (:status @response1))
    (println)
    (println "server body" (:body @response1))
    (println)
    (println)
    (println (:status @response1)))


(let [response2 (http/post "http://207.154.200.234:5000/api/blog/posts/"
    {
    :headers {"Content-Type" "application/json"}

    :body (json/write-str
        {
        :body "strong wapo"
        :title "titulo"
        :category_id 1})})]
  (println "response2 body" (:body @response2)))



;(let [response2 (http/post "http://207.154.200.234:5000/api/blog/posts/" 
;    {:query-params 
;        (json/write-str 
;            {:tittle 5 
;            :body 2})})]
;    (println "server status: " (:status @response2))
;    (println)
;    (println "server body" (:body @response2)))

;rand-nth



(section "finish section:")

;;;;;;;;;;;;;;;;;;;;;;
;;;;FINISH SECTION;;;;
;;;;;;;;;;;;;;;;;;;;;;

(Thread/sleep 200)
(loop [gensym 0]
  (println gensym)
  (if (> gensym 2)
    (println "All is done, any exception would mean that this have just been finished.")
    (do (Thread/sleep 250)
        (recur (inc gensym)))))


(shutdown-agents)

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
;(http/get http://207.154.200.234:5000/api/blog/categories/)
