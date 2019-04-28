# Labyrinth-AI

A feladatot a BME-VIK Mesterséges Intelligencia tárgy házi feladataként készítettem el. A feladat leírása alább olvasható.


**Feladat:**
A hallgató feladata, hogy a kapott labirintus kezdopontjából eljusson a végpontba, és közben az összes tárgyat felvegye.

**Bemenet:**
A hallgató a standard inputon kap egy i sorból és j oszlopból álló mátrixot. Majd kap egy számot, amely a labirintusban lévo tárgyak számát jelzi. A mátrixban 0 és 31 közötti számok szerepelnek. Minden i, j páros a labirintus egy helyét reprezentálja. A mátrix i. sorában és j. oszlopában lévo szám meghatározza, hogy a labirintus adott mezojét hol határolják falak:


• Északi fal: 1,

• Keleti fal: 2,

• Déli fal: 4,

• Nyugati fal: 8,

• Tárgy: 16,


a mátrix minden eleme ezek összegét tartalmazza (pl. ha adott mezor ˝ ol délre és nyugatra lehet menni, illetve egy tárgyat is tartalmaz, akkor a megfelelo mátrixelem 1 + 2 + 16 = 19).

**Példa:**
*Egy 3 × 3-as labirintus:*

10␣9␣7

8␣0␣19

12␣4␣2

1

**Kimenet:**
A megoldást a standard outputra kell kiírni. Egy sornak egy i, j párost kell tartalmaznia, szóközzel elválasztva, mely azt jelenti, hogy a labirintus i. sorába és j. oszlopába kíván lépni. Ha egy tárgyat tartalmazó mezőre lép, akkor azt a felvesz szót tartalmazó sorral felveheti. A megoldást egy üres sorral kell zárni. A sor szeparátor a \n karakter.


**Példa:**
*Egy lehetséges megoldás:*


1␣0

1␣1

1␣2

felvesz

2␣2


**Fontos tudnivalók:**

• A kódot Java-ban kell írni, nem tartalmazhat ékezetes vagy nem ASCII[0:127] karaktert. A beadott forráskódnak tartalmaznia kell egy Main osztályt, azon belül egy main() függvényt. Külso csomagokat nem lehet használni.

• A labirintus a bal felso sarokból, a ˝ 0, 0 pontból indul és a jobb alsó sarokba kell eljutni. Az elso mezőt már nem kell beírni, azaz az első lépés a 0 1 vagy az 1 0 sor.

• Átlósan nem lehet mozogni, és csak egyet lehet lépni. Ha valaki kilép a labirintus határain kívülre, a lépése falba ütközik, vagy nem egy szomszédos mezőbe szeretne lépni, akkor azt a labirintust nem tudta megoldani.

• Ha egy olyan helyen próbál tárgyat felvenni, ahol nincsen tárgy, akkor azt a labirintust nem tudta megoldani.

• A megoldás csak akkor elfogadható, ha az összes tárgyat felvette.

• A 15 labirintus megoldására 60 CPU sec áll rendelkezésre.

• A labirintus köröket tartalmazhat.


**Értékelés:**
Miután sikeresen megoldott egy labirintust, a program legenerálja a következot, amely az előzőnél nagyobb és több tárgyat tartalmaz. Összesen 15 labirintust kell hibátlanul, egymás után megoldani, mindegyik egy pontot ér.


