package org.mapledpmlab.type.ability;

public class PassiveBossBuff extends Ability {

    public PassiveBossBuff() {
        this.setDescription("\n어빌리티" +
                "\n1.패시브 스킬 레벨 증가 1" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.버프 지속시간 38%\n"
        );
        this.addBossDamage(10L);
        this.addPlusBuffDuration(38L);
    }
}
