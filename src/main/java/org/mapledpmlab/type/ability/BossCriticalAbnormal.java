package org.mapledpmlab.type.ability;

import org.mapledpmlab.type.etc.Common;

public class BossCriticalAbnormal extends Ability {

    public BossCriticalAbnormal() {
        this.setDescription("" +
                "\n어빌리티" +
                "\n1.보스 공격 시 데미지 20%" +
                "\n2.상태 이상에 걸린 대상 공격 시 데미지 8%" +
                "\n3.크리티컬 확률 20%\n"
        );
        this.addBossDamage(20L);
        this.addCriticalP(20.0);
        this.addStatXDamage(8L);
    }
}
