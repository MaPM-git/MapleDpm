package org.mapledpmlab.type.ability;

import org.mapledpmlab.type.etc.Common;

public class BuffBossCritical extends Ability {

    public BuffBossCritical() {
        this.setDescription("" +
                "\n어빌리티" +
                "\n1.버프 지속시간 50%" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.크리티컬 확률 20%\n"
        );
        this.addPlusBuffDuration(50L);
        this.addBossDamage(10L);
        this.addCriticalP(20.0);
    }
}
