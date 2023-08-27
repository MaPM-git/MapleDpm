package org.mapledpmlab.type.union;

public class IntUnion extends Union {

    public IntUnion() {
        super();
        this.setDescription(
                getDescription() +
                        "\n12.%미적용 주스탯 : 640" +
                        "\n13.%미적용 부스탯 : 520"
        );
        this.addPerXMainStat(640L);
        this.addPerXSubStat(480L);
        this.addPerXSubStat(40L);
    }
}
