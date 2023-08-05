package org.mapledpmlab.type.ability;

import org.mapledpmlab.type.etc.Common;

public class PassiveBossCritical extends Common {

    public PassiveBossCritical() {
        this.setDescription("" +
                "\n어빌리티" +
                "\n1.패시브 스킬 레벨 증가 1" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.크리티컬 확률 20%\n"
        );
        this.addBossDamage(10L);
        this.addCriticalP(20.0);
    }
}
