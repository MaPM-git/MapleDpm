package org.mapledpmlab.type.ability;

public class BossAbnormalAttack extends Ability {

    public BossAbnormalAttack() {
        this.setDescription("\n어빌리티" +
                "\n1.보스 공격 시 데미지 20%" +
                "\n2.상태 이상에 걸린 대상 공격 시 데미지 8%" +
                "\n3.공격력/마력 21\n"
        );
        this.addBossDamage(20L);
        this.addStatXDamage(8L);
        this.addAtt(21L);
        this.addMagic(21L);
    }
}
