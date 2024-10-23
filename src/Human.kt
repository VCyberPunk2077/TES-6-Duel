abstract class Human(
    var health:Int,
    var power:Int
):functionOfKnight,Comparable<Human> {
    abstract fun attack(human1: Human, human2: Human): String

    abstract fun heal(human: Human): String

    override fun compareTo(other: Human): Int {
        if (health==other.health) {
            return 0
        }else if(health>other.health){
            return 1
        }
        return -1
    }
}