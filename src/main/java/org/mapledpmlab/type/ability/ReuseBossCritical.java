package org.mapledpmlab.type.ability;

public class ReuseBossCritical extends Ability {

    public ReuseBossCritical() {
        this.setDescription("" +
                "\n어빌리티" +
                "\n1.재사용 대기시간 미적용 20%" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.크리티컬 확률 20%\n"
        );
        this.addReuse(20L);
        this.addBossDamage(10L);
        this.addCriticalP(20.0);
    }
}
