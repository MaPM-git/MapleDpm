package org.mapledpmlab.type.ability;

public class ReuseBossAbnormal extends Ability {

    public ReuseBossAbnormal() {
        this.setDescription("\n어빌리티" +
                "\n1.재사용 대기시간 미적용 20%" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.상태 이상에 걸린 대상 공격 시 데미지 8%\n"
        );
        this.addReuse(20.0);
        this.addBossDamage(10L);
        this.addStatXDamage(8L);
    }
}
