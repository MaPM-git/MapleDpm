package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JointAttack2 extends AttackSkill {
    public JointAttack2() {
        this.setName("조인트 어택(2타)");
        this.setAttackCount(12L);
        this.setDamage(2090.0);
        this.setDelay(900L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new JointAttack3());
        this.getMultiAttackInfo().add(450L);
        this.getMultiAttackInfo().add(450L);
    }
}
