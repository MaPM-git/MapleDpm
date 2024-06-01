package org.mapledpmlab.type.ability;

public class BossBuffCritical extends Ability {

    public BossBuffCritical() {
        this.setDescription("\n어빌리티" +
                "\n1.보스 공격 시 데미지 20%" +
                "\n2.버프 지속시간 38%" +
                "\n3.크리티컬 확률 20%\n"
        );
        this.addBossDamage(20L);
        this.addPlusBuffDuration(38L);
        this.addCriticalP(20.0);
    }
}
