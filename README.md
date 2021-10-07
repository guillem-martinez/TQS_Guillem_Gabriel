# TQS_Projecte_Guillem_Gabriel
## Joc del Blackjack

### Idea Principal
El nostre projecte constarà en fer una versió del popular joc del Blackjack.La nostra versió implementarà una versió del Blackjack on l'objectiu serà el mateix que el del joc principal, amb les cartes que tenim no sumar més de 21. Entre el jugador i la banca qui més s'apropi o iguali a 21, guanya. Afegirem un concepte on el jugador podrà tenir fitxes(diners) i apostar-los. Al entrar al joc el jugador rebrà unes fitxes i l'objectiu serà no quedar-se sense fitxes i aconseguir-ne el màxim possible.

#### Llenguatge de Programació (IDE)
Java (IntelliJ Idea)

#### Elements Bàsics
- Cartes
- Jugadors
- Banca
- Fitxes

#### Funcionalitats
##### Menu Inicial
1. Iniciar partida
2. Escollir nombre de jugadors
3. Sortir

##### Partida
1. La partida s'inicia amb un nombre determinat de fitxes per al o els jugadors. 
2. Els jugadors introdueixen la quantitat de fitxes que volen apostar-se. 
3. Es demana al jugador que seleccioni si vol rebre una carta o plantar-se.
4. Si el jugador demana una carta, la banca realitzarà la seva acció. (si la suma de cartes de la banca és superior a 16, aquesta es planta)
5. Sempre i quan les cartes del jugador no sumin més de 21 podrà plantar-se. En el cas que sumin més de 21, el jugador ha perdut directament i se li retirarà la quantitat de fitxes que havia apostat.
6. Si el jugador guanya a la banca gaunyarà la quantitat que hagi apostat.
7. Hi haurà la possibilitat de seguir jugant o de finalitzar la partida i se li mostrarà al jugador el nombre d efitxes amb el que ha finalitzat.
                7.1. Si el jugador té més fitxes que les inicials mostrarem "HAS GUANYAT x FITXES! :)"
                7.2. Si el jugador té les mateixes fitxes que les inicials mostrarem "BEN JUGAT, HAS MANTINGUT LES FITXES! :|"
                7.3. Si el jugador té menys fitxes que les inicials mostrarem "OOOH, HAS PERDUT x FITXES! :("
8. Tornarem a mostrar el menu principal
 

