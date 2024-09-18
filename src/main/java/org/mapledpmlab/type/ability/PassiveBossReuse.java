package org.mapledpmlab.type.ability;

public class PassiveBossReuse extends Ability {

    public PassiveBossReuse() {
        this.setDescription("\n어빌리티" +
                "\n1.패시브 스킬 레벨 증가 1" +
                "\n2.보스 공격 시 데미지 10%" +
                "\n3.재사용 대기시간 미적용 10%\n"
        );
        this.addBossDamage(10L);
        this.addReuse(10.0);
    }
}
