package org.mapledpmlab.type.JobContinuous;

import org.mapledpmlab.type.ability.PassiveBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class FlameWizardContinuous extends Job {

    public FlameWizardContinuous() {
        // 기본
        super();
        this.setName("플레임위자드(컨티)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.97 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (406 + 250 + 72 + 276));
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat((long) (10 + 80 + 75));
        this.addSubStat(75L);
        this.addAtt(45L);
        this.addMagic((long) (1 + 45));
        //this.addBossDamage(70L);
        //this.addMagicP(9L);
        this.addBossDamage(30L);
        this.addMagicP(21L);
        this.addMagicP(21L);

        // 0차
        this.addAttP(10L);              // 엘리멘탈 엑스퍼트
        this.addMagicP(10L);
        this.addMainStat(               // 엘리멘탈 하모니
                (this.getLevel() - 1) / 2
        );

        // 2차
        this.addMagic(20L);             // 북 오브 파이어
        this.addCriticalP(5.0);
        this.addMagic(10L);             // 주문 연마

        // 3차
        this.addFinalDamage(1.25);      // 해방된 마력
        this.addCriticalP(30.0);        // 약점 분석
        this.addCriticalDamage(20.0);
        this.addMainStat(60L);          // 번뜩이는 깨달음

        // 4차
        this.addMagic(22L);             // 마법의 진리
        this.addFinalDamage(1.56);
        this.addIgnoreDefenseList(31L); // 스피릿 오브 플레임
        this.addMagicP(3L);             // 엘리멘트 : 플레임 IV

        // 환산 보정
        this.addMainStatP(15L);
        this.addMainStat(5L);
        this.addSubStat(8L);

        this.setAbility(new PassiveBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
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
        this.addMagic(41L);             // 엘리멘트 : 플레임 IV
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
