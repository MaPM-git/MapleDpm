package org.mapledpmlab.type.union;

public class DexUnion extends Union {

    public DexUnion() {
        super();
        this.setDescription(
                getDescription() +
                "\n12.%미적용 주스탯 : 440" +
                "\n13.%미적용 부스탯 : 680"
        );
        this.addPerXMainStat(400L);
        this.addPerXSubStat(640L);
        this.addPerXMainStat(40L);
        this.addPerXSubStat(40L);
    }
}
