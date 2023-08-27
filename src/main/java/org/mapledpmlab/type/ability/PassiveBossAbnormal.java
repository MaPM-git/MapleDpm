package org.mapledpmlab.type.ability;

public class PassiveBossAbnormal extends Ability {

    public PassiveBossAbnormal() {
        this.setDescription("" +
                "\n어빌리티" +
                "\n1.패시브 스킬 레벨 증가 1" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.상태 이상에 걸린 대상 공격 시 데미지 8%\n"
        );
        this.addBossDamage(10L);
        this.addStatXDamage(8L);
    }
}
