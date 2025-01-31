package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JointAttack1 extends AttackSkill {
    public JointAttack1() {
        this.setName("조인트 어택(1타)");
        this.setAttackCount(8L);
        this.setDamage(2200.0);
        this.setDelay(90L);
        this.setCooldown(120.0);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new JointAttackFinish());
        this.getMultiAttackInfo().add(0L);
        //this.getMultiAttackInfo().add(540L);
    }
}
