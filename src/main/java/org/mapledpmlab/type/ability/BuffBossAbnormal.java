package org.mapledpmlab.type.ability;

import org.mapledpmlab.type.etc.Common;

public class BuffBossAbnormal extends Ability {

    public BuffBossAbnormal() {
        this.setDescription("" +
                "\n어빌리티" +
                "\n1.버프 지속시간 50%" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.상태 이상에 걸린 대상 공격 시 데미지 8%\n"
        );
        this.addPlusBuffDuration(50L);
        this.addBossDamage(10L);
        this.addStatXDamage(8L);
    }
}
