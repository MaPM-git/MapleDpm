package org.mapledpmlab.type.union;

public class LukUnion extends Union {

    public LukUnion() {
        super();
        this.setDescription(
                getDescription() +
                        "\n12.%미적용 주스탯 : 520" +
                        "\n13.%미적용 부스탯1 : 440" +
                        "\n14.%미적용 부스탯2 : 680"
        );
        this.addPerXMainStat(480L);
        this.addPerXSubStat(400L);
        this.addPerXOtherStat(640L);
        this.addPerXMainStat(40L);
        this.addPerXSubStat(40L);
        this.addPerXOtherStat(40L);
    }
}
