package org.mapledpmlab.type.ability;

public class BossBuffReuse extends Ability {

    public BossBuffReuse() {
        this.setDescription("\n어빌리티" +
                "\n1.보스 공격 시 데미지 20%" +
                "\n2.버프 지속시간 38%" +
                "\n3.재사용 대기시간 미적용 10%\n"
        );
        this.addBossDamage(20L);
        this.addPlusBuffDuration(38L);
        this.addReuse(10L);
    }
}
