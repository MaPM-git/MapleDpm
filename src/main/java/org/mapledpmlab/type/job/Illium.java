package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.FlowOfBattle;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Illium extends Job {

    public Illium() {
        // 기본
        super();
        this.setName("일리움(리웨)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.90 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (992));
        this.setWeaponAttMagic((long) (992));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addMagic(3L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        
        // 1차
        this.addCriticalP(20.0);        // 매직 건틀렛 마스터리
        this.addDamage(10L);            // 블레스 마크

        // 3차
        this.addDamage(15L);            // 레프 마스터리
        this.addMainStat(40L);          // 운명 개척
        this.addMagicP(10L);
        this.addMagic(50L);             // 끊임없는 연구
        this.addCriticalDamage(30.0);
        this.addCriticalP(20.0);

        // 4차
        this.addBossDamage(30L);        // 크리스탈의 비밀
        this.addIgnoreDefenseList(25L);
        this.addFinalDamage(1.47);

        // 5차
        this.addMagic(65L);             // 소울 오브 크리스탈

        // 환산 보정
        this.addMainStatP(51L);
        this.addMainStat(6L);
        this.addSubStat(-15L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new FlowOfBattle());
        this.setUnion(new IntUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addIgnoreDefenseList(20L);     // 커스 마크
        this.addAtt(46L);                   // 블레스 마크
        this.addMainStat(90L);              // 소드 오브 크리스탈 강화
        this.addSubStat(90L);
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
