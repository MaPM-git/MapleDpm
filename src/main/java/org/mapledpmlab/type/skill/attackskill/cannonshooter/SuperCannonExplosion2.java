package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SuperCannonExplosion2 extends AttackSkill {
    public SuperCannonExplosion2() {
        this.setName("슈퍼 캐논 익스플로젼(대폭발)");
        this.setAttackCount(15L);
        this.setCooldown(360.0);
        this.setDamage(12900.0);
        this.setDotDuration(2304L);
        this.setLimitAttackCount(8L);
        this.setInterval(288L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SuperCannonExplosionDelay());
    }
}
