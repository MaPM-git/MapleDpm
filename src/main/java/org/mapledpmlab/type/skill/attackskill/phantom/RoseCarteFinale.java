package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RoseCarteFinale extends AttackSkill {
    public RoseCarteFinale() {
        this.setName("로즈 카르트 피날레");
        this.setAttackCount(6L);
        this.setDamage(410.0);
        this.setDelayByAttackSpeed(780L);
        this.setCooldown(30.0);
        this.setRelatedSkill(new RoseCarteFinaleDot());
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
