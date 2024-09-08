package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackJackFinal extends AttackSkill {
    public BlackJackFinal() {
        this.setName("블랙잭(막타)");
        this.setAttackCount(6L);
        this.setDamage(1925.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(440L + 180 * 6);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
