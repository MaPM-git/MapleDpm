package org.mapledpmlab.type.ability;

public class ReuseBossBuff extends Ability {

    public ReuseBossBuff() {
        this.setDescription("\n어빌리티" +
                "\n1.재사용 대기시간 미적용 20%" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.버프 지속시간 38%\n"
        );
        this.addReuse(20.0);
        this.addBossDamage(10L);
        this.addPlusBuffDuration(38L);
    }
}
