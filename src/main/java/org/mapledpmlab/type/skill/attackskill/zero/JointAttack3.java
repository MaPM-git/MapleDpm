package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JointAttack3 extends AttackSkill {
    public JointAttack3() {
        this.setName("조인트 어택(3타)");
        this.setAttackCount(13L);
        this.setDamage(2640.0);
        this.setDelay(1080L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new JointAttackFinish());
        this.getMultiAttackInfo().add(720L);
        this.getMultiAttackInfo().add(360L);
    }
}
