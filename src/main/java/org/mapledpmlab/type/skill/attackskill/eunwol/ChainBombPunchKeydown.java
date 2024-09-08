package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainBombPunchKeydown extends AttackSkill {
    public ChainBombPunchKeydown() {
        this.setName("파쇄 연권(키다운)");
        this.setDelay(1830L - 390);
        this.setDotDuration(1800L);
        this.setInterval(120L);
        this.setLimitAttackCount(12L);
        this.setAttackCount(10L);
        this.setDamage(450.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setRelatedSkill(new ChainBombPunchEnd());
    }
}
