package org.mapledpmlab.type.ability;

public class BossAbnormalReuse extends Ability {

    public BossAbnormalReuse() {
        this.setDescription("\n어빌리티" +
                "\n1.보스 공격 시 데미지 20%" +
                "\n2.상태 이상에 걸린 대상 공격 시 데미지 8%" +
                "\n3.재사용 대기시간 미적용 10%\n"
        );
        this.addBossDamage(20L);
        this.addStatXDamage(8L);
        this.addReuse(10.0);
    }
}
