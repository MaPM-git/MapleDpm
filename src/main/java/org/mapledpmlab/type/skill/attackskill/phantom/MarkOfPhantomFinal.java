package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MarkOfPhantomFinal extends AttackSkill {
    public MarkOfPhantomFinal() {
        this.setName("마크 오브 팬텀(마지막)");
        this.setAttackCount(15L);
        this.setDamage(1055.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(1110L - 900 + 330);
        this.getMultiAttackInfo().add(30L);
    }
}
