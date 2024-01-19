package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.hero.SwordIllusionBuff;

public class SwordIllusionSlash extends AttackSkill {
    public SwordIllusionSlash() {
        this.setName("소드 일루전(참격)");
        this.setAttackCount(4L);
        this.setCooldown(30.0);
        this.setDamage(275.0);
        this.setFinalDamage(1.6);
        this.setRelatedSkill(new SwordIllusionExplosion());
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(1320L);
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
