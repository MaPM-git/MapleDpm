package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MarkOfPhantom extends AttackSkill {
    public MarkOfPhantom() {
        this.setName("마크 오브 팬텀(궤적)");
        this.setDelayByAttackSpeed(900L);
        this.setCooldown(30.0);
        this.setAttackCount(6L);
        this.setDamage(660.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new MarkOfPhantomFinal());
        this.getMultiAttackInfo().add(660L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(30L);
    }
}
