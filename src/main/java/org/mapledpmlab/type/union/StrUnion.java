package org.mapledpmlab.type.union;

import org.mapledpmlab.type.etc.Common;

public class StrUnion extends Common {

    public StrUnion() {
        this.setDescription(
                getDescription() +
                        "\n12.%미적용 주스탯 : 680" +
                        "\n13.%미적용 부스탯 : 440"
        );
        this.addPerXMainStat(640L);
        this.addPerXSubStat(400L);
        this.addPerXMainStat(40L);
        this.addPerXSubStat(40L);
    }
}
