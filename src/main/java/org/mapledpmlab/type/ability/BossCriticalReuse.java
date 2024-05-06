package org.mapledpmlab.type.ability;

public class BossCriticalReuse extends Ability {

    public BossCriticalReuse() {
        this.setDescription("" +
                "\n어빌리티" +
                "\n1.보스 공격 시 데미지 20%" +
                "\n2.크리티컬 확률 20%" +
                "\n3.재사용 대기시간 미적용 10%"
        );
        this.addBossDamage(20L);
        this.addCriticalP(20.0);
        this.addReuse(10L);
    }
}
