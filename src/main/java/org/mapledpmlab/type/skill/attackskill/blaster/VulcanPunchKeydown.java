package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VulcanPunchKeydown extends AttackSkill {
    public VulcanPunchKeydown() {
        this.setName("발칸 펀치(키다운)");
        this.setAttackCount(8L);
        this.setDamage(935.0);
        this.setDotDuration(4000L);
        this.setInterval(90L);
        this.setRelatedSkill(new VulcanPunchDelay());
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
