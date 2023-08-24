package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SuperCannonExplosion1 extends AttackSkill {
    public SuperCannonExplosion1() {
        this.setName("슈퍼 캐논 익스플로젼(폭격)");
        this.setAttackCount(12L);
        this.setCooldown(360.0);
        this.setDamage(9000.0);
        this.setDotDuration(3456L);
        this.setLimitAttackCount(12L);
        this.setInterval(288L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SuperCannonExplosion2());
    }
}
