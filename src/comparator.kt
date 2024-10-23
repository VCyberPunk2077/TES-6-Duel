class comparator: Comparator<Human> {
    override fun compare(o1: Human?, o2: Human?): Int {
        if (o1!!.health==o2!!.health) {
            return 0
        }else if(o1.health>o2.health){
            return -1
        }
        return 1
    }
}